package ASAC.Springmaster.admin.service;

import ASAC.Springmaster.domain.entity.Resources;

import java.util.List;

public interface ResourcesService {

    Resources getResources(long id);
    List<Resources> getResources();

    void createResources(Resources Resources);

    void deleteResources(long id);
}
