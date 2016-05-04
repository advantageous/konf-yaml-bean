[Konf Main Website](http://advantageous.github.io/konf/)

## Config Lib to combine YamlBeans with Konf

This lib allows you to get strongly typed config from YAML file.


Let's look at some examples.

## Combine YamlBeans with Konf strongly typed config

This project allows you to combine YamlBean YAML parser with Konf.

#### Combining YAMLBeans with Konf

```java
import static io.advantageous.konf.yaml.bean.YamlBeanConfigLoader.yamlBeanConfig;


        Config config = yamlBeanConfig("reference.yaml");
        String abc = config.getString("abc");
        assertEquals("abc", abc);

```

#### Combining YamlBeans Yaml with Konf Config.
```java

import static io.advantageous.config.ConfigLoader.configs;
import static io.advantageous.config.ConfigLoader.config;


        Config config = configs(yamlBeanConfig("reference.yaml"), 
                         config("test-config.js"));

```

