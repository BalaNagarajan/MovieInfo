package com.jcircle.movieinfo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@Setter
@Getter
public class BaseResponse implements Serializable {

    private List<String> errorMessages;
    private List<String> userMessages;


}