package org.gb.demobprj.response;

import java.util.List;

public interface PageRes<T> {
    int getCurrentPage();
    List<T> getContent();
    int getPageSize();
    int getTotalPages();
    int getTotalElements();

}
