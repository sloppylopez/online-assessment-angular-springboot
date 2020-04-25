import {browser, by, element} from 'protractor';

export class AppPage {
  navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl) as Promise<unknown>;
  }

  getCaptionText(): Promise<string> {
    return element(by.css('app-root .content caption')).getText() as Promise<string>;
  }

  getTableHeadText(id: string): Promise<string> {
    return element(by.css(`app-root .content #${id}`)).getText() as Promise<string>;
  }
}
