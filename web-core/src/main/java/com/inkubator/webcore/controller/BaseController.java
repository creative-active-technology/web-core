/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inkubator.webcore.controller;

import java.io.Serializable;
import org.apache.log4j.Logger;

/**
 *
 * @author Deni Husni Fahri Rizal
 * @version 1
 * @since 10 February 2014
 */
public abstract class BaseController implements Serializable{
     protected transient Logger logger = Logger.getLogger(getClass());
    
}
