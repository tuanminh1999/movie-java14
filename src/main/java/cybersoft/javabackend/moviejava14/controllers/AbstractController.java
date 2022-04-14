package cybersoft.javabackend.moviejava14.controllers;

import cybersoft.javabackend.moviejava14.cumRap.service.CumRapService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {
    @Autowired
    protected CumRapService cumRapService;
}
