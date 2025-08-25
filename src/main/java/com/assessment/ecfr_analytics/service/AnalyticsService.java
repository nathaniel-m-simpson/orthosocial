package com.assessment.ecfr_analytics.service;

import com.assessment.ecfr_analytics.data.Agencies;
import com.assessment.ecfr_analytics.data.Corrections;
import com.assessment.ecfr_analytics.data.Titles;
import com.assessment.ecfr_analytics.model.Title;
import com.assessment.ecfr_analytics.repository.AgencyMetaDataRepository;
import com.assessment.ecfr_analytics.repository.CorrectionsRepository;
import com.assessment.ecfr_analytics.repository.TitlesMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class AnalyticsService {

    private final AgencyMetaDataRepository agencyMetaDataRepository;

    private final TitlesMetaDataRepository titlesMetaDataRepository;

    private final CorrectionsRepository correctionsRepository;

    private final WebClient webClient;

    @Value("${efcr.api.agency.metadata.url}")
    private String efcrApiAgencyMetadataUrl;

    @Value("${efcr.api.corrections.url}")
    private String efcrApiCorrectionsUrl;

    @Value("${efcr.api.titles.metadata.url}")
    private String efcrApiTitlesMetadataUrl;

    @Value("${file.download.dir}")
    private String fileDownloadDir;

    @Value("${efcr.api.source.xmls.url}")
    private String efcrApiSourceXmlsUrl;

    @Autowired
    public AnalyticsService(AgencyMetaDataRepository agencyMetaDataRepository,
                            TitlesMetaDataRepository titlesMetaDataRepository, CorrectionsRepository correctionsRepository,
                            WebClient webClient) {
        this.agencyMetaDataRepository = agencyMetaDataRepository;
        this.titlesMetaDataRepository = titlesMetaDataRepository;
        this.correctionsRepository = correctionsRepository;
        this.webClient = webClient;
    }

    public ResponseEntity performCfrDataRefresh() {
        // Persisting agency metadata
        this.webClient.get().uri(efcrApiAgencyMetadataUrl).accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Agencies.class).subscribe(agencies ->
                                agencyMetaDataRepository.saveAll(agencies.getAgencies()),
                        error ->
                                // Handle any errors that occur during the request
                                System.err.println("Error: " + error.getMessage())
                );

        // Persisting Title metadata
        List<Title> titles = this.webClient.get().uri(efcrApiTitlesMetadataUrl).accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Titles.class).block().getTitles();

        titlesMetaDataRepository.saveAll(titles);

        // Downloading corrections data and title xmls in file structure
        titles.forEach(this::downloadCorrectionsAndTitleXml);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    private void downloadCorrectionsAndTitleXml(Title title) {
        if (Objects.isNull(title.getNumber()) || Objects.isNull(title.getUpToDateAsOf())) {
            return;
        }

        // Persisting corrections
        this.webClient.get().uri(uriBuilder -> uriBuilder
                        .path(efcrApiCorrectionsUrl)
                        .build(title.getNumber()))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Corrections.class).subscribe(corrections ->
                                correctionsRepository.saveAll(corrections.getCorrections()),
                        error ->
                                // Handle any errors that occur during the request
                                System.err.println("Error: " + error.getMessage())
                );

        System.out.println("Downloading title xml: " + title);
//        String filename = title.getUpToDateAsOf() + "-title-" + title.getNumber() + ".xml";
//
//        Path fileDownloadPath = Paths.get(System.getProperty("user.dir")).resolveSibling(fileDownloadDir)
//                .resolve(filename);
//        try {
//            Flux<DataBuffer> flux = this.webClient.get().
//                    uri(uriBuilder -> uriBuilder
//                            .path(efcrApiSourceXmlsUrl)
//                            .build(title.getUpToDateAsOf(), title.getNumber()))
//                    .retrieve()
//                    .bodyToFlux(DataBuffer.class);
//
//            DataBufferUtils.write(flux, fileDownloadPath).subscribe();
//        } catch (Exception e) {
//            System.err.println("Error saving XML content: " + e.getMessage());
//        }

        System.out.println("Finished downloading title xml: " + title);
    }
}
