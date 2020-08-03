package com.quovantis.quovantis.services;

import com.quovantis.quovantis.entity.OfferEntity;
import com.quovantis.quovantis.exception.DuplicateDataException;
import com.quovantis.quovantis.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.quovantis.quovantis.model.*;

/**
 * Created by Dhiraj on 31-07-2020.
 */
@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferRepository offerRepository;

    /**
     * This method save the data      *
     * @param offerBean
     * @throws Exception
     */
    @Override
    public void save(OfferBean offerBean)throws Exception  {
        OfferEntity entity = offerRepository.getOfferByJobTitle(offerBean.getJobTitle());
        if (entity!=null) {
            throw new DuplicateDataException("Duplicate Record:");
        }else {
            OfferEntity offerEntity = getOfferEntity(offerBean);
            offerRepository.save(offerEntity);
        }
    }

    @Override
    public OfferBean getOffer(String offerId) {
        OfferBean offerBean=null;
        OfferEntity entity = offerRepository.getOne(Long.parseLong(offerId));
        offerBean=getOfferBean(entity);
        return offerBean;
    }

    /**
     * @return List of offerBean
     */
    @Override
    public List<OfferBean> getOffers() {
        List<OfferEntity> entities = offerRepository.findAll();
        List<OfferBean> beanList = new ArrayList<>();
        entities.forEach(x -> {
            try {
                beanList.add(getBeanFromEntity(x));
            } catch (ParseException e) {
              e.printStackTrace();
            }
        });
        return beanList;

    }

    /**
     * This method set the data from OfferBean to OfferEntity
     * @param bean
     * @return OfferEntity
     */
    private OfferEntity getOfferEntity(OfferBean bean) {
        OfferEntity entity = new OfferEntity();
        entity.setJobTital(bean.getJobTitle());
        entity.setStartDate(bean.getStartDate());
        return entity;
    }

    private OfferBean getOfferBean(OfferEntity entity){
        OfferBean bean = new OfferBean();
        bean.setJobTital(entity.getJobTital());
        bean.setStartDate(entity.getStartDate());
       return bean;
    }

    /**
     *  This method set the data from OfferEntity to OfferBean
     *
     * @param entity
     * @return OfferBean
     * @throws ParseException
     */
    private OfferBean getBeanFromEntity(OfferEntity entity) throws ParseException {
        OfferBean bean = new OfferBean();
        bean.setJobTital(entity.getJobTital());
        bean.setOfferId(entity.getOfferId());
        bean.setStartDate(entity.getStartDate());
        bean.setNumberOfApplications(entity.getApplications().size());
        return bean;
    }

}
