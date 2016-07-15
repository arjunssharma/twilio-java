/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.fetcher.trunking.v1.trunk;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.fetcher.Fetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.trunking.v1.trunk.IpAccessControlList;

public class IpAccessControlListFetcher extends Fetcher<IpAccessControlList> {
    private final String trunkSid;
    private final String sid;

    /**
     * Construct a new IpAccessControlListFetcher.
     * 
     * @param trunkSid The trunk_sid
     * @param sid The sid
     */
    public IpAccessControlListFetcher(final String trunkSid, 
                                      final String sid) {
        this.trunkSid = trunkSid;
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched IpAccessControlList
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public IpAccessControlList execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.TRUNKING,
            "/v1/Trunks/" + this.trunkSid + "/IpAccessControlLists/" + this.sid + "",
            client.getAccountSid()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("IpAccessControlList fetch failed: Unable to connect to server");
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
        
        return IpAccessControlList.fromJson(response.getStream(), client.getObjectMapper());
    }
}