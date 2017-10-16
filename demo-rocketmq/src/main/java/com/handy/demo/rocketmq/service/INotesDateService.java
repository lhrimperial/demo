package com.handy.demo.rocketmq.service;


import com.handy.demo.rocketmq.domain.NotesDate;

/**
 * @author longhairen
 * @create 2017/10/11 0011 上午 10:31
 */
public interface INotesDateService {

    void save(NotesDate notesDate);

    NotesDate findById(int id);
}
