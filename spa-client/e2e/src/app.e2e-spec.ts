import {AppPage} from './app.po';
import {browser, logging} from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should navigate to page', () => {
    page.navigateTo();
  });

  it('should display table caption', () => {
    expect(page.getCaptionText()).toEqual('Failed Transactions Report');
  });

  it('should display table headers', () => {
    expect(page.getTableHeadText("referenceHeader")).toEqual('Reference');
    expect(page.getTableHeadText("descriptionHeader")).toEqual('Description');
    expect(page.getTableHeadText("errorHeader")).toEqual('Error');
  });

  it('should display table cells with correct values', () => {
    expect(page.getTableHeadText("reference0")).toEqual('189177');
    expect(page.getTableHeadText("description0")).toEqual('Subscription for Erik Dekker');
    expect(page.getTableHeadText("error0")).toEqual('5429-939 != 6368');

    expect(page.getTableHeadText("reference1")).toEqual('148480');
    expect(page.getTableHeadText("description1")).toEqual('Flowers for Richard Bakker');
    expect(page.getTableHeadText("error1")).toEqual('10.1-0.3 != 9.8');

    expect(page.getTableHeadText("reference2")).toEqual('119225');
    expect(page.getTableHeadText("description2")).toEqual('Candy for Willem Theuß');
    expect(page.getTableHeadText("error2")).toEqual('53.7-48.14 != 5.56');

    expect(page.getTableHeadText("reference3")).toEqual('163215');
    expect(page.getTableHeadText("description3")).toEqual('Subscription for Erik Theuß');
    expect(page.getTableHeadText("error3")).toEqual('3980+1000 != 4981');
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
