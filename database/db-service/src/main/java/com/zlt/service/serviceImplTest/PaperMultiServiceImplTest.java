//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zlt.service.serviceImplTest;

import com.zlt.pojo.EduPapermulti;
import com.zlt.service.PaperMultiService;
import com.zlt.utils.UUIDUtil;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperMultiServiceImplTest {
    @Autowired(
            required = false
    )
    private PaperMultiService paperMultiService;

    @Test
    public void all() {
        EduPapermulti eduPapermulti = new EduPapermulti();
        eduPapermulti.setId(UUIDUtil.getUUID());
        eduPapermulti.setPaperId("01");
        eduPapermulti.setMultiId("01");
        eduPapermulti.setReserv1("111");
        eduPapermulti.setReserv2("111");
        eduPapermulti.setUpdateTime(new Timestamp((new Date()).getTime()));
        eduPapermulti.setCreateTime(new Timestamp((new Date()).getTime()));
        this.paperMultiService.addPaperMulti(eduPapermulti);
        System.out.println(this.paperMultiService.findAllPaperMulti());
        EduPapermulti eduPapermulti1 = this.paperMultiService.findPaperMultiById("52b7a71acc4d407e8aa86b17fb2ce20f");
        System.out.println(eduPapermulti);
        eduPapermulti1.setCreateTime(new Timestamp((new Date()).getTime()));
        System.out.println(this.paperMultiService.updatePaperMulti(eduPapermulti1));
        System.out.println(this.paperMultiService.deletePaperMulti("52b7a71acc4d407e8aa86b17fb2ce20f"));
    }
}
