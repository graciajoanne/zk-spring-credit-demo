package services;


import model.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> findAll();

    List<Application> search(String keyword);

    void add(Application application);
}