import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;


import java.util.concurrent.LinkedBlockingQueue;

public class TwitterStatusUpdate {

    public static void main(String args[]) throws Exception{
        {
            {

                String consumerKey = "BfdfcfOvGktY0D4CUaGUuvjcc";
                String consumerSecret = "LCcSGzXbKYkSoV6CdUSWNaK4UoJLdVrGr3fTIKJyVsXyif71l5";
                String accessToken = "3195562729-eVZdGWISNLba7ybD1T6FcGZnX2vK5XDAfL4XpGg";
                String accessTokenSecret = "RDgJJJy4yAqeIds08RtpMtng9j4peIOOwwIP86sDz0etB";
                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true)
                        .setOAuthConsumerKey(consumerKey)
                        .setOAuthConsumerSecret(consumerSecret)
                        .setOAuthAccessToken(accessToken)
                        .setOAuthAccessTokenSecret(accessTokenSecret);

                Twitter twitter = new TwitterFactory(cb.build()).getInstance();

                try {
                    RequestToken requestToken = twitter.getOAuthRequestToken();

                    System.out.println("Request token: " + requestToken.getToken());
                    System.out.println("Request token secret: " + requestToken.getTokenSecret());
                    AccessToken accessTokenNew = null;
                }

                catch (IllegalStateException ie) {

                    if (!twitter.getAuthorization().isEnabled()) {
                        System.out.println("OAuth consumer key/secret is not set.");
                    }
                }

                Status update = twitter.updateStatus("Hello everyone");
                System.out.println("Successfully updated the status to ["   + update.getText() + "].");
                Thread.sleep(5000);
            }
        }
    }
}
