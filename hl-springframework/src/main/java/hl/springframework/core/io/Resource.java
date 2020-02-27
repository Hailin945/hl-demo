package hl.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取资源信息流的基本接口
 *
 * @author Hailin
 * @date 2020/2/21
 */
public interface Resource {

    /**
     * 获取不同资源位置下的流信息
     *
     * @return 读取到的资源输入流
     */
    InputStream getInputStream() throws IOException;
}
