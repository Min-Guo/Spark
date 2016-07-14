import twitter4j.{Trends, TwitterFactory, Twitter}
import twitter4j.conf.ConfigurationBuilder
object TrendingTopics {
    def main(args: Array[String]) {

      // (1) config work to create a twitter object
      val cb = new ConfigurationBuilder()
      cb.setDebugEnabled(true)
        .setOAuthConsumerKey("dvUkoBr8N3kePgtaNXgFqIW2E")
        .setOAuthConsumerSecret("6Yix2c6gn5oGbOcdDsIgLkLy4EoJvjdArl2wcVnJT2hkdJBeA0")
        .setOAuthAccessToken("2523499370-jKz9tm4RWh96HcNs1G6kN5wMsUeuT3eJXSGoiAV")
        .setOAuthAccessTokenSecret("Wy29SE0LZBL2xoHo3mAv17e4mSNYK18Hfh59dzDSUzW9i")
      val tf = new TwitterFactory(cb.build())
      val twitter = tf.getInstance()

      // (2) use the twitter object to get your friend's timeline
      val trends = twitter.getPlaceTrends(23424977);
      System.out.println("WorldWide Trends:")
      for (i <- trends.getTrends()) {
        System.out.println(i.getName())
      }
    }
}
