package cn.com.soframe.kafka;

import cn.com.soframe.kafka.entity.KafkaMessage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author fujh
 * @since 2020年9月7日16:30:57
 * Kafka消息生产者
 */
@Component
@Slf4j
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String ,String> kafkaTemplate;

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(KafkaMessage message){
        kafkaTemplate.send("kafka_topic1", JSON.toJSONString(message));
    }

    /**
     * 发送消息
     * @param key
     * @param message
     */
    public void sendMessage(String key, KafkaMessage message){
        kafkaTemplate.send("kafka_topic1" ,key , JSONObject.toJSONString(message));
    }

}
