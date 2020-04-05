package com.zj.port.commons.log;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.zj.port.commons.annotation.ThreadSafe;

/**
 * 分布式日志框架,traceId数据容器
 * 
 * @author gewx
 **/
@ThreadSafe 
public final class ThreadContext {

	public static final TransmittableThreadLocal<String> TRACEID = new TransmittableThreadLocal<String>();

}
