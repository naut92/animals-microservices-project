/*package animals_app.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@EnableRabbit

@Configuration
public class RabbitExchangeConfig {

*/
 /*
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("animals-app");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
*/


    /*настраиваем соединение с RabbitMQ
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange("exchange-example-5");
        return rabbitTemplate;
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("query-example-5-1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("query-example-5-2");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("exchange-example-5");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(topicExchange()).with("*.orange.*");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("*.*.rabbit");
    }

    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("lazy.#");
    }
}
*/