package com.handy.demo.web.test;

import com.alibaba.fastjson.JSON;
import com.handy.demo.web.domain.NotesDate;
import com.handy.demo.web.service.INotesDateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author longhairen
 * @create 2017/10/11 0011 上午 10:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring.xml"})
public class NotesDateTest {
    @Autowired
    private INotesDateService notesDateService;

    @Test
    public void test1() {
        NotesDate notesDate = notesDateService.findById(1);
        System.out.println(JSON.toJSONString(notesDate));
    }

    @Test
    public void test() {
        NotesDate notesDate = new NotesDate();
        notesDate.setNotes("notes");
        notesDate.setCreateTime(new Date());
        notesDate.setCreateDatetime(new Date());
        notesDate.setCreateDate(new Date());
        notesDate.setCreateTimestrap(new Date());
        notesDateService.save(notesDate);
    }

    public INotesDateService getNotesDateService() {
        return notesDateService;
    }

    public void setNotesDateService(INotesDateService notesDateService) {
        this.notesDateService = notesDateService;
    }
}
