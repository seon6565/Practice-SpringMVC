package org.fullstack4.springmvc.sample;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class SampleService {

    //@Qualifier("event")
    private final SampleDAO sampleDAO;

}
