/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.webcore.controller;

import com.inkubator.webcore.util.FacesUtil;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;

/**
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 10 February 2014
 */
public abstract class BaseController implements Serializable {

    protected transient Logger LOGGER = Logger.getLogger(getClass());
    protected String bahasa;

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    @PostConstruct
    public void initialization() {
        LOGGER.info("Base Controlller Execute");
        bahasa = (String) FacesUtil.getSessionAttribute("bahasa_active");
        FacesUtil.getFacesContext().getViewRoot().setLocale(new Locale(bahasa));
        
    }
     public String doClose() {
        return "home";
    }

}
