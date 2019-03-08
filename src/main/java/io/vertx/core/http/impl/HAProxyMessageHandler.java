package io.vertx.core.http.impl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.haproxy.HAProxyMessage;
import io.netty.util.AttributeKey;

public class HAProxyMessageHandler extends SimpleChannelInboundHandler<HAProxyMessage> {
  static final AttributeKey<HAProxyMessage> HA_PROXY_MESSAGE_ATTRIBUTE_KEY = AttributeKey.valueOf("haProxyMessage");

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, HAProxyMessage haProxyMessage) {
    channelHandlerContext.channel().attr(HA_PROXY_MESSAGE_ATTRIBUTE_KEY).set(haProxyMessage);
    channelHandlerContext.pipeline().remove(this);
  }
}
