/*
 * Copyright (c) 2020, The Magma Authors
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.openschema.mma.metrics.collectors;

import android.content.Context;

import java.util.List;

import androidx.core.util.Pair;

/**
 * TODO: javadocs
 */
public abstract class BaseMetrics {
    private static final String TAG = "BaseMetrics";

    public BaseMetrics(Context context) { }

    //Used in metrics that can be collected synchronously.
    public abstract List<Pair<String, String>> retrieveMetrics();

    //Used in metrics that need to be collected asynchronously.
    public interface MetricsCollectorListener {
        void onMetricCollected(String metricName, List<Pair<String, String>> metricsList);
    }
}