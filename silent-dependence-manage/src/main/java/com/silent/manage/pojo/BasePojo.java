package com.silent.manage.pojo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * \* User: silent
 * \* Date: 27/11/17 Time: 18:57
 * \* Description:
 * \
 */
public class BasePojo implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(BasePojo.class);

    private static final long serialVersionUID = -6624726557956559047L;

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String ret = "";
        try {
            ret = mapper.writeValueAsString(this);
        } catch (Exception e) {
            logger.error("BaseBo-->toString error" + e.toString());
        }
        return ret;
    }
}
