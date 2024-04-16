package org.fullstack4.springmvc.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Qualifier("normal")
@Repository
public class SampleDAOImpl implements SampleDAO{
}
