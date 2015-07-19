package models

import com.ning.http.client.AsyncHttpClientConfig
import play.api.libs.oauth.ConsumerKey
import play.api.libs.oauth.OAuthCalculator
import play.api.libs.oauth.RequestToken
import play.api.libs.ws.DefaultWSClientConfig
import play.api.libs.ws.ning.NingAsyncHttpClientConfigBuilder
import play.api.libs.ws.ning.NingWSClient

object DefaultEnvironment {
  val config  = new NingAsyncHttpClientConfigBuilder(DefaultWSClientConfig()).build()
  val builder = new AsyncHttpClientConfig.Builder(config)
  val client  = new NingWSClient(builder.build)

  val defaultEnvironment = TwitterEnv(
    client,
    OAuthCalculator(
      ConsumerKey(
        "key",
        "secret"
      ),
      RequestToken(
        "token",
        "secret"
      )
    )
  )
}