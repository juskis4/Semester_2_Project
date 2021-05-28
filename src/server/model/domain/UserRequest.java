package server.model.domain;

/**
 * A class that represents user request.
 */
public class UserRequest
{
  private String request;

  /**
   * User request constructor.
   * @param request
   */
  public UserRequest(String request)
  {
    this.request = request;
  }

  /**
   * A getter for request.
   * @return
   */
  public String getRequest()
  {
    return request;
  }
}
