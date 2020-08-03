package com.quovantis.quovantis.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.quovantis.quovantis.constant.ApplicationStatus;
import com.quovantis.quovantis.entity.ApplicationEntity;
import com.quovantis.quovantis.entity.OfferEntity;
import com.quovantis.quovantis.exception.DuplicateDataException;
import com.quovantis.quovantis.model.*;
import com.quovantis.quovantis.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dhiraj on 01-08-2020.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Override
    public void save(ApplicationBean applicationBean) throws Exception {
        ApplicationEntity applicationEntity= null;
        ApplicationEntity entity = applicationRepository.getApplicationByEmail(applicationBean.getCandidateEmail());
        if (entity!=null) {
            throw new DuplicateDataException("Duplicate Record:");
        }else {
            applicationEntity = getApplicationEntity(applicationBean);
            applicationRepository.save(applicationEntity);
        }
    }


    @Override
    public ApplicationBean getApplicationById(String applicationId) {
        ApplicationBean applicationBean=null;
        ApplicationEntity entity = applicationRepository.getOne(Long.parseLong(applicationId));
        applicationBean=getApplicationBean(entity);
        return applicationBean;
    }

    /**
     * @return List of applicationBean
     */
    @Override
    public List<ApplicationBean> getApplications() {
        List<ApplicationEntity> entities = applicationRepository.findAll();
        List<ApplicationBean> beanList = new ArrayList<>();
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
     * This method set the data from applicationBean to applicationEntity
     * @param bean
     * @return applicationEntity
     */
    private ApplicationEntity getApplicationEntity(ApplicationBean bean) {
        ApplicationEntity entity = new ApplicationEntity();
       entity.setApplicationStatus(bean.getApplicationStatus());
        entity.setCandidateEmail(bean.getCandidateEmail());
        entity.setResumeText(bean.getResumeText());
        OfferEntity offer = new OfferEntity();
        offer.setOfferId(Long.valueOf(bean.getOfferBean().getOfferId()));
        entity.setOffer(offer);
        return entity;
    }

    private ApplicationBean getApplicationBean(ApplicationEntity entity){
        ApplicationBean bean = new ApplicationBean();
        bean.setApplicationId(entity.getApplicationId());
        bean.setApplicationStatus(entity.getApplicationStatus());
        bean.setCandidateEmail(entity.getCandidateEmail());
        bean.setResumeText(entity.getResumeText());
        return bean;
    }

    /**
     *  This method set the data from ApplicationEntity to ApplicationBean
     *
     * @param entity
     * @return applicationBean
     * @throws ParseException
     */
    private ApplicationBean getBeanFromEntity(ApplicationEntity entity) throws ParseException {
        ApplicationBean bean = new ApplicationBean();
        bean.setApplicationId(entity.getApplicationId());
        bean.setApplicationStatus(entity.getApplicationStatus());
        bean.setCandidateEmail(entity.getCandidateEmail());
        bean.setResumeText(entity.getResumeText());
        return bean;

    }

}
