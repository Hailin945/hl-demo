package com.hl.activemq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * ActiveMQ消费端
 *
 * @author Hailin
 * @date 2020/2/2
 */
public class ConsumerTest {

    @Test
    public void QueueTest() {
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            String brokerUrl = "tcp://127.0.0.1:61616";
            // 1、创建连接工厂
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
            // 2、通过连接工厂创建连接
            connection = connectionFactory.createConnection();
            // 3、启动连接
            connection.start();
            // 4、通过连接获取session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 5、通过session获取destination
            Queue queue = session.createQueue("test_queue");
            // 6、通过session获取消费端
            consumer = session.createConsumer(queue);
            // 7、消费端同步接收消息
            Message message = consumer.receive();
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println(textMessage.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (consumer != null) {
                    consumer.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void topicTest() {
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            String brokerUrl = "tcp://127.0.0.1:61616";
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("test_topic");
            consumer = session.createConsumer(topic);
            System.out.println("console 1 :");
            Message message = consumer.receive();
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println(textMessage.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (consumer != null) {
                    consumer.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
