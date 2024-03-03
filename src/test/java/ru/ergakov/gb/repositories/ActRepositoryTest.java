package ru.ergakov.gb.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.ergakov.gb.model.Act;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ActRepositoryTest {

    @Autowired
    private ActRepository actRepository;

    @Test
    void findActByReportingPeriod() {
        Act act1 = new Act();
        act1.setId(1L);
        act1.setReportingPeriod("February");
        act1.setProjectSection("EOM");
        act1.setPrice(100.0);
        act1.setStatus("Accept");

        Act act2 = new Act();
        act2.setId(2L);
        act2.setReportingPeriod("January");
        act2.setProjectSection("TX");
        act2.setPrice(200.0);
        act2.setStatus("In Checking");

        actRepository.save(act1);
        actRepository.save(act2);

        String period = "February";
        List<Act> resultList = actRepository.findActByReportingPeriod(period);

        assertThat(resultList).isNotNull();
        assertThat(resultList.size()).isEqualTo(1);



    }
}