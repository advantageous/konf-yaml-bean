package io.advantageous.konf.yaml.bean;

import com.esotericsoftware.yamlbeans.YamlReader;
import io.advantageous.config.Config;
import io.advantageous.config.ConfigLoader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static io.advantageous.config.ResourceUtils.findResource;

@SuppressWarnings("WeakerAccess")
public class YamlBeanConfigLoader {


    /**
     * Alias for loadYamlResources.
     *
     * @param resources classpath resources to from which to load javascript
     * @return Config.
     */
    public static Config yamlBeanConfig(final String... resources) {
        return loadYamlResources(resources);
    }

    /**
     * Loads a config files as Strict JSON.
     *
     * @param resources classpath resources to from which to load javascript
     * @return Config.
     */
    public static Config loadYamlResources(final String... resources) {
        final List<Config> configList = new ArrayList<>(resources.length);
        for (String resource : resources) {
            configList.add(loadYamlResource(resource));
        }
        return ConfigLoader.configs(configList.toArray(new Config[configList.size()]));
    }

    /**
     * Loads a config files as Strict JSON.
     *
     * @param resource classpath resources to from which to load javascript
     * @return Config.
     */
    public static Config loadYamlResource(final String resource) {

        try (final InputStream inputStream = findResource(resource)) {
            InputStreamReader reader = new InputStreamReader(inputStream);
            return ConfigLoader.loadFromObject(new YamlReader(reader).read());
        } catch (final Exception e) {
            throw new IllegalArgumentException("unable to parse YAML. " + resource, e);
        }
    }


}
