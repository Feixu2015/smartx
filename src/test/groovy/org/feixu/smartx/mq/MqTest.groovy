/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.mq

import org.junit.Test
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired

/**
 *
 *
 * @author Feixu
 * @version $Id: MqTest.java, v 0.1 2018/8/20 Feixu Exp $
 */
class MqTest {
    @Autowired
    RabbitTemplate rabbitTemplate

    @Test
    void abc(){
        rabbitTemplate.receiveAndConvert("123")
    }
}
