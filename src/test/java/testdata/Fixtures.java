package testdata;

import org.apache.commons.lang3.RandomStringUtils;

public class Fixtures {

  public String title = RandomStringUtils.random(10, true, false);
  public String review = RandomStringUtils.random(30, true, true);
}
