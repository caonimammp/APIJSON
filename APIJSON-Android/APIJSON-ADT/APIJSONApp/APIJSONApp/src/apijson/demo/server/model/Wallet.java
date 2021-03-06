/*Copyright ©2016 TommyLemon(https://github.com/TommyLemon/APIJSON)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package apijson.demo.server.model;

import static zuo.biao.apijson.RequestRole.ADMIN;
import static zuo.biao.apijson.RequestRole.OWNER;

import java.math.BigDecimal;

import zuo.biao.apijson.MethodAccess;

/**钱包类，已用UserPrivacy替代
 * @author Lemon
 * @see
 * <br >POST_GET:<pre>
{
    "Wallet":{
        "disallow":"!",
        "necessary":"id"
    }
}
 * </pre>
 * <br >POST:post/wallet<pre>
{
    "Wallet":{
        "disallow":"!",
        "necessary":"id"
    },
    "necessary":"payPassword"
}
 * </pre>
 * <br >PUT:put/wallet<pre>
{
    "Wallet":{
        "disallow":"!",
        "necessary":"id,balance+"
    },
    "necessary":"payPassword"
}
 * </pre>
 * <br >DELETE:delete/wallet<pre>
{
    "Wallet":{
        "disallow":"!",
        "necessary":"id"
    },
    "necessary":"payPassword"
}
 * </pre>
 */
@Deprecated
@MethodAccess(
		GET = {},
		HEAD = {},
		POST_GET = {OWNER, ADMIN},
		POST_HEAD = {OWNER, ADMIN},
		POST = {ADMIN},
		DELETE = {ADMIN}
		)
public class Wallet extends BaseModel {
	private static final long serialVersionUID = 1L;

	public BigDecimal balance;

	/**默认构造方法，JSON等解析时必须要有
	 */
	public Wallet() {
		super();
	}
	public Wallet(long id) {
		this();
		setId(id);
	}


	public Wallet setUserId(long userId) {
		setId(userId);
		return this;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	public Wallet setBalance(BigDecimal balance) {
		this.balance = balance;
		return this;
	}

}
