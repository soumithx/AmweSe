
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder
import com.amazonaws.{ClientConfiguration,Protocol}
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicSessionCredentials


def Grabkeys(rArn:String,prxyHst:String,PrxyPort:Int,Creds:BasicSessionCredentials):STSAssumeRoleSessionCredentialsProvider={
  val ClienConfig = new ClientConfiguration()
  ClienConfig.setProtocol(Protocol.HTTPS)
  ClienConfig.setProxyHost(prxyHst)
  ClienConfig.setProxyPort(PrxyPort)
  val SecutiyTokenClien = AWSSecurityTokenServiceClientBuilder.standard().withClientConfiguration(ClienConfig).withCredentials(new AWSStaticCredentialsProvider(Creds)).build()
  new STSAssumeRoleSessionCredentialsProvider.Builder(rArn,"Source").withStsClient(SecutiyTokenClien).build()
}
