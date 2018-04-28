/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class CallUpdater extends Updater<Call> {
    private String pathAccountSid;
    private final String pathSid;
    private URI url;
    private HttpMethod method;
    private Call.UpdateStatus status;
    private URI fallbackUrl;
    private HttpMethod fallbackMethod;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;

    /**
     * Construct a new CallUpdater.
     * 
     * @param pathSid Call Sid that uniquely identifies the Call to update
     */
    public CallUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Construct a new CallUpdater.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Call Sid that uniquely identifies the Call to update
     */
    public CallUpdater(final String pathAccountSid, 
                       final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    /**
     * The fully qualified URL that should be consulted when the call connects. Just
     * like when you set a URL on a phone number for handling inbound calls. See the
     * [Url
     * Parameter](https://www.twilio.com/docs/api/voice/making-calls#url-parameter)
     * section below for more details..
     * 
     * @param url URL that returns TwiML
     * @return this
     */
    public CallUpdater setUrl(final URI url) {
        this.url = url;
        return this;
    }

    /**
     * The fully qualified URL that should be consulted when the call connects. Just
     * like when you set a URL on a phone number for handling inbound calls. See the
     * [Url
     * Parameter](https://www.twilio.com/docs/api/voice/making-calls#url-parameter)
     * section below for more details..
     * 
     * @param url URL that returns TwiML
     * @return this
     */
    public CallUpdater setUrl(final String url) {
        return setUrl(Promoter.uriFromString(url));
    }

    /**
     * The HTTP method Twilio should use when making its request to the above `Url`
     * parameter's value. Defaults to `POST`. If an `ApplicationSid` parameter is
     * present, this parameter is ignored..
     * 
     * @param method HTTP method to use to fetch TwiML
     * @return this
     */
    public CallUpdater setMethod(final HttpMethod method) {
        this.method = method;
        return this;
    }

    /**
     * Either `canceled` or `completed`. Specifying `canceled` will attempt to hang
     * up calls that are queued or ringing but not affect calls already in progress.
     * Specifying `completed` will attempt to hang up a call even if it's already in
     * progress..
     * 
     * @param status Status to update the Call with
     * @return this
     */
    public CallUpdater setStatus(final Call.UpdateStatus status) {
        this.status = status;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML at `Url`. If an `ApplicationSid` parameter is present, this parameter
     * is ignored..
     * 
     * @param fallbackUrl Fallback URL in case of error
     * @return this
     */
    public CallUpdater setFallbackUrl(final URI fallbackUrl) {
        this.fallbackUrl = fallbackUrl;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML at `Url`. If an `ApplicationSid` parameter is present, this parameter
     * is ignored..
     * 
     * @param fallbackUrl Fallback URL in case of error
     * @return this
     */
    public CallUpdater setFallbackUrl(final String fallbackUrl) {
        return setFallbackUrl(Promoter.uriFromString(fallbackUrl));
    }

    /**
     * The HTTP method that Twilio should use to request the `FallbackUrl`. Must be
     * either `GET` or `POST`. Defaults to `POST`. If an `ApplicationSid` parameter
     * is present, this parameter is ignored..
     * 
     * @param fallbackMethod HTTP Method to use with FallbackUrl
     * @return this
     */
    public CallUpdater setFallbackMethod(final HttpMethod fallbackMethod) {
        this.fallbackMethod = fallbackMethod;
        return this;
    }

    /**
     * A URL that Twilio will send asynchronous webhook requests to on every call
     * event specified in the `StatusCallbackEvent` parameter. If no event is
     * present, Twilio will send `completed` by default. If an `ApplicationSid`
     * parameter is present, this parameter is ignored. URLs must contain a valid
     * hostname (underscores are not permitted)..
     * 
     * @param statusCallback Status Callback URL
     * @return this
     */
    public CallUpdater setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * A URL that Twilio will send asynchronous webhook requests to on every call
     * event specified in the `StatusCallbackEvent` parameter. If no event is
     * present, Twilio will send `completed` by default. If an `ApplicationSid`
     * parameter is present, this parameter is ignored. URLs must contain a valid
     * hostname (underscores are not permitted)..
     * 
     * @param statusCallback Status Callback URL
     * @return this
     */
    public CallUpdater setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method Twilio should use when requesting the above URL. Defaults to
     * `POST`. If an `ApplicationSid` parameter is present, this parameter is
     * ignored..
     * 
     * @param statusCallbackMethod HTTP Method to use with StatusCallback
     * @return this
     */
    public CallUpdater setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Call
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Call update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Calls/" + this.pathSid + ".json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Call update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Call.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (url != null) {
            request.addPostParam("Url", url.toString());
        }

        if (method != null) {
            request.addPostParam("Method", method.toString());
        }

        if (status != null) {
            request.addPostParam("Status", status.toString());
        }

        if (fallbackUrl != null) {
            request.addPostParam("FallbackUrl", fallbackUrl.toString());
        }

        if (fallbackMethod != null) {
            request.addPostParam("FallbackMethod", fallbackMethod.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }
    }
}