/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

import com.twilio.base.Creator;
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

public class TollFreeCreator extends Creator<TollFree> {
    private String pathAccountSid;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private String apiVersion;
    private String friendlyName;
    private String smsApplicationSid;
    private HttpMethod smsFallbackMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsMethod;
    private URI smsUrl;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private String voiceApplicationSid;
    private Boolean voiceCallerIdLookup;
    private HttpMethod voiceFallbackMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceMethod;
    private URI voiceUrl;
    private String identitySid;
    private String addressSid;

    /**
     * Construct a new TollFreeCreator.
     * 
     * @param phoneNumber The phone number you want to purchase.
     */
    public TollFreeCreator(final com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Construct a new TollFreeCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param phoneNumber The phone number you want to purchase.
     */
    public TollFreeCreator(final String pathAccountSid, 
                           final com.twilio.type.PhoneNumber phoneNumber) {
        this.pathAccountSid = pathAccountSid;
        this.phoneNumber = phoneNumber;
    }

    /**
     * The Twilio REST API version to use for incoming calls made to this number. If
     * omitted, uses `2010-04-01`..
     * 
     * @param apiVersion The Twilio REST API version to use for incoming calls made
     *                   to this number.
     * @return this
     */
    public TollFreeCreator setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * A human readable description of the new incoming phone number. Maximum 64
     * characters. Defaults to a formatted version of the number..
     * 
     * @param friendlyName A human readable description of the new incoming phone
     *                     number.
     * @return this
     */
    public TollFreeCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The 34 character sid of the application Twilio should use to handle SMSs sent
     * to the new number. If a `SmsApplicationSid` is present, Twilio will ignore
     * all of the SMS urls above and use those set on the application..
     * 
     * @param smsApplicationSid The 34 character sid of the application Twilio
     *                          should use to handle SMSs sent to the new number.
     * @return this
     */
    public TollFreeCreator setSmsApplicationSid(final String smsApplicationSid) {
        this.smsApplicationSid = smsApplicationSid;
        return this;
    }

    /**
     * The HTTP method that should be used to request the `SmsFallbackUrl`. Must be
     * either `GET` or `POST`. Defaults to `POST`..
     * 
     * @param smsFallbackMethod The HTTP method that should be used to request the
     *                          SmsFallbackUrl.
     * @return this
     */
    public TollFreeCreator setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML defined by `SmsUrl`..
     * 
     * @param smsFallbackUrl A URL that Twilio will request if an error occurs
     *                       requesting or executing the TwiML defined by SmsUrl.
     * @return this
     */
    public TollFreeCreator setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML defined by `SmsUrl`..
     * 
     * @param smsFallbackUrl A URL that Twilio will request if an error occurs
     *                       requesting or executing the TwiML defined by SmsUrl.
     * @return this
     */
    public TollFreeCreator setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    /**
     * The HTTP method that should be used to request the `SmsUrl`. Must be either
     * `GET` or `POST`. Defaults to `POST`..
     * 
     * @param smsMethod The HTTP method that should be used to request the SmsUrl.
     * @return this
     */
    public TollFreeCreator setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * The URL that Twilio should request when somebody sends an SMS to the phone
     * number..
     * 
     * @param smsUrl The URL that Twilio should request when somebody sends an SMS
     *               to the phone number.
     * @return this
     */
    public TollFreeCreator setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The URL that Twilio should request when somebody sends an SMS to the phone
     * number..
     * 
     * @param smsUrl The URL that Twilio should request when somebody sends an SMS
     *               to the phone number.
     * @return this
     */
    public TollFreeCreator setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    /**
     * The URL that Twilio will request to pass status parameters (such as call
     * ended) to your application..
     * 
     * @param statusCallback The URL that Twilio will request to pass status
     *                       parameters to your application.
     * @return this
     */
    public TollFreeCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL that Twilio will request to pass status parameters (such as call
     * ended) to your application..
     * 
     * @param statusCallback The URL that Twilio will request to pass status
     *                       parameters to your application.
     * @return this
     */
    public TollFreeCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method Twilio will use to make requests to the `StatusCallback` URL.
     * Either `GET` or `POST`. Defaults to `POST`..
     * 
     * @param statusCallbackMethod The HTTP method Twilio will use to make requests
     *                             to the StatusCallback URL.
     * @return this
     */
    public TollFreeCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * The 34 character sid of the application Twilio should use to handle phone
     * calls to the new number. If a `VoiceApplicationSid` is present, Twilio will
     * ignore all of the voice urls above and use those set on the application.
     * Setting a `VoiceApplicationSid` will automatically delete your `TrunkSid` and
     * vice versa..
     * 
     * @param voiceApplicationSid The 34 character sid of the application Twilio
     *                            should use to handle phone calls to the new
     *                            number.
     * @return this
     */
    public TollFreeCreator setVoiceApplicationSid(final String voiceApplicationSid) {
        this.voiceApplicationSid = voiceApplicationSid;
        return this;
    }

    /**
     * Do a lookup of a caller's name from the CNAM database and post it to your
     * app. Either `true` or `false`. Defaults to `false`..
     * 
     * @param voiceCallerIdLookup Do a lookup of a caller's name from the CNAM
     *                            database and post it to your app.
     * @return this
     */
    public TollFreeCreator setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    /**
     * The HTTP method that should be used to request the `VoiceFallbackUrl`. Either
     * `GET` or `POST`. Defaults to `POST`..
     * 
     * @param voiceFallbackMethod The HTTP method that should be used to request
     *                            the VoiceFallbackUrl.
     * @return this
     */
    public TollFreeCreator setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML at `Url`..
     * 
     * @param voiceFallbackUrl A URL that Twilio will request if an error occurs
     *                         requesting or executing the TwiML at Url.
     * @return this
     */
    public TollFreeCreator setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * A URL that Twilio will request if an error occurs requesting or executing the
     * TwiML at `Url`..
     * 
     * @param voiceFallbackUrl A URL that Twilio will request if an error occurs
     *                         requesting or executing the TwiML at Url.
     * @return this
     */
    public TollFreeCreator setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    /**
     * The HTTP method that should be used to request the `VoiceUrl`. Must be either
     * `GET` or `POST`. Defaults to `POST`..
     * 
     * @param voiceMethod The HTTP method that should be used to request the
     *                    VoiceUrl.
     * @return this
     */
    public TollFreeCreator setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * The URL that Twilio should request when somebody dials the new phone number.
     * The VoiceURL will  no longer be used if a `VoiceApplicationSid` or a
     * `TrunkSid` is set..
     * 
     * @param voiceUrl The URL that Twilio should request when somebody dials the
     *                 new phone number.
     * @return this
     */
    public TollFreeCreator setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The URL that Twilio should request when somebody dials the new phone number.
     * The VoiceURL will  no longer be used if a `VoiceApplicationSid` or a
     * `TrunkSid` is set..
     * 
     * @param voiceUrl The URL that Twilio should request when somebody dials the
     *                 new phone number.
     * @return this
     */
    public TollFreeCreator setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    /**
     * The identity_sid.
     * 
     * @param identitySid The identity_sid
     * @return this
     */
    public TollFreeCreator setIdentitySid(final String identitySid) {
        this.identitySid = identitySid;
        return this;
    }

    /**
     * The 34 character sid of the address Twilio should associate with the number..
     * 
     * @param addressSid The 34 character sid of the address Twilio should
     *                   associate with the number.
     * @return this
     */
    public TollFreeCreator setAddressSid(final String addressSid) {
        this.addressSid = addressSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created TollFree
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public TollFree create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/IncomingPhoneNumbers/TollFree.json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("TollFree creation failed: Unable to connect to server");
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

        return TollFree.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());
        }

        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (smsApplicationSid != null) {
            request.addPostParam("SmsApplicationSid", smsApplicationSid);
        }

        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
        }

        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
        }

        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
        }

        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }

        if (voiceApplicationSid != null) {
            request.addPostParam("VoiceApplicationSid", voiceApplicationSid);
        }

        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());
        }

        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());
        }

        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());
        }

        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());
        }

        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());
        }

        if (identitySid != null) {
            request.addPostParam("IdentitySid", identitySid);
        }

        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);
        }
    }
}