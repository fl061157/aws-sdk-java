/*
 * Copyright 2010-2014 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.rds.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import com.amazonaws.services.rds.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * List Tags For Resource Request Marshaller
 */
public class ListTagsForResourceRequestMarshaller implements Marshaller<Request<ListTagsForResourceRequest>, ListTagsForResourceRequest> {

    public Request<ListTagsForResourceRequest> marshall(ListTagsForResourceRequest listTagsForResourceRequest) {

        if (listTagsForResourceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListTagsForResourceRequest> request = new DefaultRequest<ListTagsForResourceRequest>(listTagsForResourceRequest, "AmazonRDS");
        request.addParameter("Action", "ListTagsForResource");
        request.addParameter("Version", "2014-09-01");

        if (listTagsForResourceRequest.getResourceName() != null) {
            request.addParameter("ResourceName", StringUtils.fromString(listTagsForResourceRequest.getResourceName()));
        }

        java.util.List<Filter> filtersList = listTagsForResourceRequest.getFilters();
        int filtersListIndex = 1;

        for (Filter filtersListValue : filtersList) {
            Filter filterMember = filtersListValue;
            if (filterMember != null) {
                if (filterMember.getName() != null) {
                    request.addParameter("Filters.Filter." + filtersListIndex + ".Name", StringUtils.fromString(filterMember.getName()));
                }

                java.util.List<String> valuesList = filterMember.getValues();
                int valuesListIndex = 1;

                for (String valuesListValue : valuesList) {
                    if (valuesListValue != null) {
                        request.addParameter("Filters.Filter." + filtersListIndex + ".Values.Value." + valuesListIndex, StringUtils.fromString(valuesListValue));
                    }

                    valuesListIndex++;
                }
            }

            filtersListIndex++;
        }

        return request;
    }
}
