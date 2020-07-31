package com.zlt.service;


import com.zlt.pojo.EduPapermulti;

import java.util.List;

public interface PaperMultiService {
    List<EduPapermulti> findAllPaperMulti();
    List<EduPapermulti> findPaperMultiById(String id);
    int addPaperMulti(EduPapermulti eduPapermulti);
    int updatePaperMulti(EduPapermulti eduPapermulti);
    int deletePaperMulti(String id);
}
