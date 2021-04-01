package com.zy.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.*;

/**
 * @author zhuangy
 * @version V1.0
 * @Title: CanalDataEventListener
 * @Package com.zy.listener
 * @Description: (用一句话描述该文件做什么)
 * @date 2021/4/1 0001 15:16
 **/
@CanalEventListener
public class CanalDataEventListener {
    @UpdateListenPoint(schema = "changgou_goods", table = {"tb_template"})
    public void updateListen(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.out.println(eventType);
        System.out.println(rowData);
    }

    @InsertListenPoint
    public void createListen(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

    }

    @DeleteListenPoint
    public void deleteListen(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

    }
}
