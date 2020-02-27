package hl.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类路径下的资源对象
 *
 * @author Hailin
 * @date 2020/2/21
 */
public class ClassPathResource implements Resource {

    private String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        if (path == null || "".equals(path)) {
            return null;
        }
        return this.getClass().getResourceAsStream(this.path);
    }
}
