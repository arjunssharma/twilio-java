/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace;

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

public class WorkflowCreator extends Creator<Workflow> {
    private final String pathWorkspaceSid;
    private final String friendlyName;
    private final String configuration;
    private URI assignmentCallbackUrl;
    private URI fallbackAssignmentCallbackUrl;
    private Integer taskReservationTimeout;

    /**
     * Construct a new WorkflowCreator.
     * 
     * @param pathWorkspaceSid The workspace_sid
     * @param friendlyName A string representing a human readable name for this
     *                     Workflow.
     * @param configuration JSON document configuring the rules for this Workflow.
     */
    public WorkflowCreator(final String pathWorkspaceSid, 
                           final String friendlyName, 
                           final String configuration) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.friendlyName = friendlyName;
        this.configuration = configuration;
    }

    /**
     * A valid URL for the application that will process task assignment events. See
     * [Handling Task Assignment
     * Callback](https://www.twilio.com/docs/api/taskrouter/handling-assignment-callbacks) for more details..
     * 
     * @param assignmentCallbackUrl A valid URL for the application that will
     *                              process task assignment events.
     * @return this
     */
    public WorkflowCreator setAssignmentCallbackUrl(final URI assignmentCallbackUrl) {
        this.assignmentCallbackUrl = assignmentCallbackUrl;
        return this;
    }

    /**
     * A valid URL for the application that will process task assignment events. See
     * [Handling Task Assignment
     * Callback](https://www.twilio.com/docs/api/taskrouter/handling-assignment-callbacks) for more details..
     * 
     * @param assignmentCallbackUrl A valid URL for the application that will
     *                              process task assignment events.
     * @return this
     */
    public WorkflowCreator setAssignmentCallbackUrl(final String assignmentCallbackUrl) {
        return setAssignmentCallbackUrl(Promoter.uriFromString(assignmentCallbackUrl));
    }

    /**
     * If the request to the AssignmentCallbackUrl fails, the assignment callback
     * will be made to this URL..
     * 
     * @param fallbackAssignmentCallbackUrl If the request to the
     *                                      AssignmentCallbackUrl fails, the
     *                                      assignment callback will be made to this
     *                                      URL.
     * @return this
     */
    public WorkflowCreator setFallbackAssignmentCallbackUrl(final URI fallbackAssignmentCallbackUrl) {
        this.fallbackAssignmentCallbackUrl = fallbackAssignmentCallbackUrl;
        return this;
    }

    /**
     * If the request to the AssignmentCallbackUrl fails, the assignment callback
     * will be made to this URL..
     * 
     * @param fallbackAssignmentCallbackUrl If the request to the
     *                                      AssignmentCallbackUrl fails, the
     *                                      assignment callback will be made to this
     *                                      URL.
     * @return this
     */
    public WorkflowCreator setFallbackAssignmentCallbackUrl(final String fallbackAssignmentCallbackUrl) {
        return setFallbackAssignmentCallbackUrl(Promoter.uriFromString(fallbackAssignmentCallbackUrl));
    }

    /**
     * An integer value controlling how long in seconds TaskRouter will wait for a
     * confirmation response from your application after assigning a Task to a
     * worker. See Task Assignment Callback for more information. Defaults to 120
     * seconds. Maximum value is 86400 (24 hours).
     * 
     * @param taskReservationTimeout An integer value controlling how long in
     *                               seconds TaskRouter will wait for a confirmation
     *                               response from your application after assigning
     *                               a Task to a worker.
     * @return this
     */
    public WorkflowCreator setTaskReservationTimeout(final Integer taskReservationTimeout) {
        this.taskReservationTimeout = taskReservationTimeout;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Workflow
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Workflow create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Workflows",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Workflow creation failed: Unable to connect to server");
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

        return Workflow.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (configuration != null) {
            request.addPostParam("Configuration", configuration);
        }

        if (assignmentCallbackUrl != null) {
            request.addPostParam("AssignmentCallbackUrl", assignmentCallbackUrl.toString());
        }

        if (fallbackAssignmentCallbackUrl != null) {
            request.addPostParam("FallbackAssignmentCallbackUrl", fallbackAssignmentCallbackUrl.toString());
        }

        if (taskReservationTimeout != null) {
            request.addPostParam("TaskReservationTimeout", taskReservationTimeout.toString());
        }
    }
}