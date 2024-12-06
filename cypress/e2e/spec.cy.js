describe('API Tests for Publication', () => {
  const baseUrl = 'http://localhost:8080';

  it('Should return no publications for a non-existent year', () => {
    cy.request({
      method: 'GET',
      url: `${baseUrl}/findByYear/2025`,
      failOnStatusCode: false, // Não falhe em status diferentes de 2xx
    }).then((response) => {
      expect(response.status).to.eq(404); // Status esperado
      expect(response.body.message).to.eq('Nenhuma publicação encontrada para o ano informado!');
    });
  });
});

describe('API Tests for Publications in 2024', () => {
  const baseUrl = 'http://localhost:8080';
  const expectedResponse = [
    {
      title: "Life Science 2.0: reframing the life science sector for 'the benefit on mankind'.",
      authors: null,
      journal: "Glob Health Action",
      year: 2024,
      published: "2024-12-31",
      volume: 17,
      issue: "1",
      pages: "2330758",
      doi: "10.1080/16549716.2024.2330758",
      pmid: 38577884,
      labels: ["Chemical Biology Consortium Sweden (CBCS)"],
      qualifiers: ["Collaborative"],
      iuid: "583c21cc266645d7bc7d8a71a6a815e3",
      url: "https://publications.scilifelab.se/publication/583c21cc266645d7bc7d8a71a6a815e3",
      doiUrl: "https://doi.org/10.1080/16549716.2024.2330758",
      pubMedUrl: "https://pubmed.ncbi.nlm.nih.gov/38577884/",
      epublished: "2024-04-05",
      issn: null,
      issnL: null,
    },
    {
      title: "The evolutionary history of metastatic pancreatic neuroendocrine tumours reveals a therapy driven route to high-grade transformation.",
      authors: null,
      journal: "J. Pathol.",
      year: 2024,
      published: "2024-12-01",
      volume: 264,
      issue: "4",
      pages: "357-370",
      doi: "10.1002/path.6348",
      pmid: 39360347,
      labels: ["Bioinformatics Support for Computational Resources"],
      qualifiers: [],
      iuid: "94ab6b3617474bc092224f924b8f0d46",
      url: "https://publications.scilifelab.se/publication/94ab6b3617474bc092224f924b8f0d46",
      doiUrl: "https://doi.org/10.1002/path.6348",
      pubMedUrl: "https://pubmed.ncbi.nlm.nih.gov/39360347/",
      epublished: "2024-10-03",
      issn: null,
      issnL: null,
    },
    {
      title: "Scifer: An R/Bioconductor package for large-scale integration of Sanger sequencing and flow cytometry data of index-sorted single cells",
      authors: null,
      journal: "Immunoinformatics (Amst)",
      year: 2024,
      published: "2024-12-01",
      volume: 16,
      issue: null,
      pages: "100046",
      doi: "10.1016/j.immuno.2024.100046",
      pmid: null,
      labels: ["Clinical Genomics Uppsala"],
      qualifiers: ["Service"],
      iuid: "99f60b817821490f9e17cd2af2cecd6a",
      url: "https://publications.scilifelab.se/publication/99f60b817821490f9e17cd2af2cecd6a",
      doiUrl: "https://doi.org/10.1016/j.immuno.2024.100046",
      pubMedUrl: null,
      epublished: "2024-12-01",
      issn: null,
      issnL: null,
    },
    {
      title: "Occurrence of cancer in Marfan syndrome: Report of two patients with neuroblastoma and review of the literature.",
      authors: null,
      journal: "Am. J. Med. Genet. A",
      year: 2024,
      published: "2024-12-01",
      volume: 194,
      issue: "12",
      pages: "e63812",
      doi: "10.1002/ajmg.a.63812",
      pmid: 38990105,
      labels: [],
      qualifiers: [],
      iuid: "b6ffc8e552274a4cbea5108dcbbda724",
      url: "https://publications.scilifelab.se/publication/b6ffc8e552274a4cbea5108dcbbda724",
      doiUrl: "https://doi.org/10.1002/ajmg.a.63812",
      pubMedUrl: "https://pubmed.ncbi.nlm.nih.gov/38990105/",
      epublished: "2024-07-11",
      issn: null,
      issnL: null,
    },
    {
      title: "Longitudinal Analysis of Natural History Progression of Rare and Ultra-Rare Cerebellar Ataxias Using Item Response Theory.",
      authors: null,
      journal: "Clin. Pharmacol. Ther.",
      year: 2024,
      published: "2024-12-01",
      volume: 116,
      issue: "6",
      pages: "1593-1605",
      doi: "10.1002/cpt.3466",
      pmid: 39403821,
      labels: [],
      qualifiers: [],
      iuid: "a3e0296764c54e03ba99681fee25bca5",
      url: "https://publications.scilifelab.se/publication/a3e0296764c54e03ba99681fee25bca5",
      doiUrl: "https://doi.org/10.1002/cpt.3466",
      pubMedUrl: "https://pubmed.ncbi.nlm.nih.gov/39403821/",
      epublished: "2024-10-15",
      issn: null,
      issnL: null,
    },
    {
      title: "Lifestyle, biological, and genetic factors related to brain iron accumulation across adulthood.",
      authors: null,
      journal: "Neurobiol. Aging",
      year: 2024,
      published: "2024-12-01",
      volume: 144,
      issue: null,
      pages: "56-67",
      doi: "10.1016/j.neurobiolaging.2024.09.004",
      pmid: 39277972,
      labels: [],
      qualifiers: [],
      iuid: "ae5f4ce1bcc449d2bd0c22369b2de2a8",
      url: "https://publications.scilifelab.se/publication/ae5f4ce1bcc449d2bd0c22369b2de2a8",
      doiUrl: "https://doi.org/10.1016/j.neurobiolaging.2024.09.004",
      pubMedUrl: "https://pubmed.ncbi.nlm.nih.gov/39277972/",
      epublished: "2024-09-10",
      issn: null,
      issnL: null,
    },
  ];

  it('Should return a list of publications for the year 2024', () => {
    cy.request({
      method: 'GET',
      url: `${baseUrl}/findByYear/2024`,
      failOnStatusCode: false,
    }).then((response) => {
      expect(response.status).to.eq(200);
      expect(response.body).to.have.length(expectedResponse.length);
      response.body.forEach((item, index) => {
        expect(item).to.deep.include(expectedResponse[index]);
      });
    });
  });
});

describe('API Tests for Publications by DOI', () => {
  const baseUrl = 'http://localhost:8080';

  it('Should fetch publication by DOI', () => {
    cy.request({
      method: 'GET',
      url: `${baseUrl}/findByDoi`,
      qs: { doi: '10.1080/16549716.2024.2330758' }, // Query parameters
    }).then((response) => {
      expect(response.status).to.eq(200);
      expect(response.body).to.deep.equal({
        title: "Life Science 2.0: reframing the life science sector for 'the benefit on mankind'.",
        authors: null,
        journal: "Glob Health Action",
        year: 2024,
        published: "2024-12-31",
        volume: 17,
        issue: "1",
        pages: "2330758",
        doi: "10.1080/16549716.2024.2330758",
        pmid: 38577884,
        labels: ["Chemical Biology Consortium Sweden (CBCS)"],
        qualifiers: ["Collaborative"],
        iuid: "583c21cc266645d7bc7d8a71a6a815e3",
        url: "https://publications.scilifelab.se/publication/583c21cc266645d7bc7d8a71a6a815e3",
        doiUrl: "https://doi.org/10.1080/16549716.2024.2330758",
        pubMedUrl: "https://pubmed.ncbi.nlm.nih.gov/38577884/",
        epublished: "2024-04-05",
        issn: null,
        issnL: null,
      });
    });
  });
});
