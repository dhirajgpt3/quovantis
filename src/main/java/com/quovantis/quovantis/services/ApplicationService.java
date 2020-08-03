package com.quovantis.quovantis.services;

import java.util.List;
import com.quovantis.quovantis.model.*;

/**
 * Created by Dhiraj on 01-08-2020.
 */
public interface ApplicationService {
    void save(ApplicationBean applicationBean) throws Exception;
    ApplicationBean  getApplicationById(String applicationId);
    List<ApplicationBean> getApplications();
}
