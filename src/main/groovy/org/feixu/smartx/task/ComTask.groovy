/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.task
/**
 *
 * @author Feixu
 * @version $Id: ComTask.java, v 0.1 2017/11/20 Feixu Exp $$
 */
class ComTask {
    private static WEEK_DAY_MAP = [
            1: '星期一',
            2: '星期二',
            3: '星期三',
            4: '星期四',
            5: '星期五',
            6: '星期六',
            7: '星期日',
    ]
    /**
     * 日报写日期及提纲
     */
    static void writeTaskLine(now) {
        if(null == now) {
            now = new Date()
        }

        6. times {
            Date day = now.updated(dayOfMonth:now[Calendar.DAY_OF_MONTH] + it)
            println "${day.format("yyyy-MM-dd")} ${WEEK_DAY_MAP[Integer.valueOf(day.format('u'))]}"
            println """任务：
BUG：
沟通：
会议：
"""
        }
    }
}
