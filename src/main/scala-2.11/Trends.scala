
import twitter4j.{QueryResult, Trends, TwitterFactory, Twitter, Query, Status, TwitterException}
import twitter4j.conf.ConfigurationBuilder

import scala.collection.mutable.ArrayBuffer

object TrendingTopics {
  def getTrends(f: Unit): ArrayBuffer[String] = {

    //config work to create a twitter object
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("dvUkoBr8N3kePgtaNXgFqIW2E")
      .setOAuthConsumerSecret("6Yix2c6gn5oGbOcdDsIgLkLy4EoJvjdArl2wcVnJT2hkdJBeA0")
      .setOAuthAccessToken("2523499370-jKz9tm4RWh96HcNs1G6kN5wMsUeuT3eJXSGoiAV")
      .setOAuthAccessTokenSecret("Wy29SE0LZBL2xoHo3mAv17e4mSNYK18Hfh59dzDSUzW9i")
    val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()

    //use the twitter object to get your friend's timeline
    val trends = twitter.getPlaceTrends(23424977);
    var trendingWords: ArrayBuffer[String] = new ArrayBuffer[String]()
    for (i <- trends.getTrends()) {
      trendingWords += i.getName()
    }
    return trendingWords;
  }

  //remove hashTag
  def parseTopics(f: ArrayBuffer[String]): ArrayBuffer[String] = {
    val noTagWords: ArrayBuffer[String] = new ArrayBuffer[String]();
    for (i <- f) {
      noTagWords += i.filterNot(_ == '#')
    }
    return noTagWords
  }

  //search query
  def searchQuery(f: ArrayBuffer[String]) = {
    for (i <- f) {
      //config work to create a twitter object
      val cb = new ConfigurationBuilder()
      cb.setDebugEnabled(true)
        .setOAuthConsumerKey("dvUkoBr8N3kePgtaNXgFqIW2E")
        .setOAuthConsumerSecret("6Yix2c6gn5oGbOcdDsIgLkLy4EoJvjdArl2wcVnJT2hkdJBeA0")
        .setOAuthAccessToken("2523499370-jKz9tm4RWh96HcNs1G6kN5wMsUeuT3eJXSGoiAV")
        .setOAuthAccessTokenSecret("Wy29SE0LZBL2xoHo3mAv17e4mSNYK18Hfh59dzDSUzW9i")
      val tf = new TwitterFactory(cb.build())
      val twitter = tf.getInstance()
      val query = new Query(i)
      query.setCount(10)
      try {
        val queryResult = twitter.search(query)
        val tweets = queryResult.getTweets()
        val it = tweets.iterator();
        while (it.hasNext()) {
          val status = it.next()
          //val country = status.getPlace()
          //val location = status.getPlace().getCountry().equals("Germany")
          System.out.println(i)
          System.out.println(status.getText())

        }
      }
      catch {
        case te: TwitterException => println("exception caught: " + te);
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val words: ArrayBuffer[String] = parseTopics(getTrends())
    searchQuery(words)
  }
}
