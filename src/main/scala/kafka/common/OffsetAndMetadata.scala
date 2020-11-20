package kafka.common

import java.util.Optional

case class OffsetAndMetadata(offset: Long,
                             leaderEpoch: Optional[Integer],
                             metadata: String,
                             commitTimestamp: Long,
                             expireTimestamp: Long) {


  override def toString: String = {
    s"OffsetAndMetadata(offset=$offset" +
      s", leaderEpoch=$leaderEpoch" +
      s", metadata=$metadata" +
      s", commitTimestamp=$commitTimestamp" +
      s", expireTimestamp=$expireTimestamp)"
  }
}

object OffsetAndMetadata {
  val NoMetadata: String = ""

  def apply(offset: Long, metadata: String, commitTimestamp: Long): OffsetAndMetadata = {
    OffsetAndMetadata(offset, Optional.empty(), metadata, commitTimestamp,org.apache.kafka.common.requests.OffsetCommitRequest.DEFAULT_TIMESTAMP)
  }

  def apply(offset: Long, metadata: String, commitTimestamp: Long, expireTimestamp: Long): OffsetAndMetadata = {
    OffsetAndMetadata(offset, Optional.empty(), metadata, commitTimestamp, expireTimestamp)
  }

  def apply(offset: Long, leaderEpoch: Optional[Integer], metadata: String, commitTimestamp: Long): OffsetAndMetadata = {
    OffsetAndMetadata(offset, leaderEpoch, metadata, commitTimestamp)
  }

  def apply(offsetAndMeta: OffsetMetadata, commitTimestamp: Long, expireTimestamp: Long): OffsetAndMetadata = {
    OffsetAndMetadata(offsetAndMeta.offset, Optional.empty(), offsetAndMeta.metadata, commitTimestamp, expireTimestamp)
  }

}