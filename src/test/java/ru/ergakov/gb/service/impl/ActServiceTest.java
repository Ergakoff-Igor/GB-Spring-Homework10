package ru.ergakov.gb.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ergakov.gb.model.Act;
import ru.ergakov.gb.repositories.ActRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActServiceTest {

    @Mock
    private ActRepository actRepository;
    @InjectMocks
    private ActServiceImpl actService;
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

        List<Act> acts = new ArrayList<>();
        acts.add(act1);
        acts.add(act2);

        when(actRepository.findAll()).thenReturn(acts);

        actService.findActByReportingPeriod("February");

        verify(actRepository).findActByReportingPeriod("February");

        assertEquals(1, actRepository.findActByReportingPeriod("February").size());
    }
}