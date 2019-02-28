package com.dmap.common.utils;

import com.dmap.base.junit.BaseTestRoot;
import com.silent.common.utils.paryTime.PrayTime;
import com.silent.common.utils.paryTime.SunriseBo;
import org.junit.Test;

/**
 * \* User: silent
 * \* Date: 09/10/18 Time: 10:09
 * \* Description:
 * \
 */
public class PayTimeTest extends BaseTestRoot {


    @Test
    public void spiderWeather() throws Exception {
        SunriseBo sunriseBo = PrayTime.getSunriseAndSunSetTime(51.5073509, -0.127758, 2);
        System.out.println("sunrise : " + sunriseBo.getSunrise() + "sunset : " + sunriseBo.getSunset());
    }
}
