module xyz.cryptomaven.maplmq {

    requires xyz.cryptomaven.mq.maplmq.TopicTwo;

    exports com.friendsofgroot.cli.models.User to  xyz.cryptomaven.mq.maplmq.MessageTypes;
}