package wuxc.wisdomparty.layout;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class dialogfour extends Dialog {

	public dialogfour(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public dialogfour(Context context, int theme) {
		super(context, theme);
	}

	public static class Builder {
		private Context context;
		private String title;
		private String message;
		private String positiveButtonText;
		private String negativeButtonText;
		private View contentView;
		private DialogInterface.OnClickListener positiveButtonClickListener;
		private DialogInterface.OnClickListener negativeButtonClickListener;
		private DialogInterface.OnClickListener qqZoneClickListener;
		private DialogInterface.OnClickListener qqClickListener;
		private DialogInterface.OnClickListener WeChatClickListener;
		private DialogInterface.OnClickListener WeFriendsClickListener;

		public Builder(Context context) {
			this.context = context;
		}

		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}

		/**
		 * Set the Dialog message from resource
		 * 
		 * @param titleActivity
		 * @return
		 */
		public Builder setMessage(int message) {
			this.message = (String) context.getText(message);
			return this;
		}

		/**
		 * Set the Dialog title from resource
		 * 
		 * @param title
		 * @return
		 */
		public Builder setTitle(int title) {
			this.title = (String) context.getText(title);
			return this;
		}

		/**
		 * Set the Dialog title from String
		 * 
		 * @param title
		 * @return
		 */

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setContentView(View v) {
			this.contentView = v;
			return this;
		}

		/**
		 * Set the positive button resource and it's listener
		 * 
		 * @param positiveButtonText
		 * @return
		 */
		public Builder setPositiveButton(int positiveButtonText, DialogInterface.OnClickListener listener) {
			this.positiveButtonText = (String) context.getText(positiveButtonText);
			this.positiveButtonClickListener = listener;
			return this;
		}

		public Builder setPositiveButton(String positiveButtonText, DialogInterface.OnClickListener listener) {
			this.positiveButtonText = positiveButtonText;
			this.positiveButtonClickListener = listener;
			return this;
		}

		public Builder setNegativeButton(int negativeButtonText, DialogInterface.OnClickListener listener) {
			this.negativeButtonText = (String) context.getText(negativeButtonText);
			this.negativeButtonClickListener = listener;
			return this;
		}

		public Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener) {
			this.negativeButtonText = negativeButtonText;
			this.negativeButtonClickListener = listener;
			return this;
		}

		public Builder setQQZoneImage(DialogInterface.OnClickListener listener) {
			this.qqZoneClickListener = listener;
			return this;
		}

		public Builder setQQImage(DialogInterface.OnClickListener listener) {
			this.qqClickListener = listener;
			return this;
		}

		public Builder setWeChatImage(DialogInterface.OnClickListener listener) {
			this.WeChatClickListener = listener;
			return this;
		}

		public Builder setWeFriendsImage(DialogInterface.OnClickListener listener) {
			this.WeFriendsClickListener = listener;
			return this;
		}

		public dialogfour create() {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final dialogfour dialog = new dialogfour(context, R.style.Dialog);
			final View layout = inflater.inflate(R.layout.dialogfour, null);
			dialog.addContentView(layout, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.MATCH_PARENT));
			if (positiveButtonText != null) {
				((Button) layout.findViewById(R.id.positiveButton)).setText(positiveButtonText);
				if (positiveButtonClickListener != null) {
					((Button) layout.findViewById(R.id.positiveButton)).setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);

						}
					});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.positiveButton).setVisibility(View.GONE);
			}
			// set the cancel button
			if (negativeButtonText != null) {
				((Button) layout.findViewById(R.id.negativeButton)).setText(negativeButtonText);
				if (negativeButtonClickListener != null) {
					((Button) layout.findViewById(R.id.negativeButton)).setOnClickListener(new View.OnClickListener() {

						public void onClick(View v) {
							negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);

						}
					});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.negativeButton).setVisibility(View.GONE);
			}

			if (qqClickListener != null) {
				((ImageView) layout.findViewById(R.id.ImageQQ)).setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						qqClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);

					}
				});
			}
			if (qqZoneClickListener != null) {
				((ImageView) layout.findViewById(R.id.ImageQQZone)).setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						qqZoneClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);

					}
				});
			}
			if (WeChatClickListener != null) {
				((ImageView) layout.findViewById(R.id.ImageWeChat)).setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						WeChatClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);

					}
				});
			}
			if (WeFriendsClickListener != null) {
				((ImageView) layout.findViewById(R.id.ImageWeFriends)).setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						WeFriendsClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);

					}
				});
			}

			// set the content message
			if (message != null) {
				((TextView) layout.findViewById(R.id.message)).setText(message);
			} else if (contentView != null) {
				// if no message set
				// add the contentView to the dialog body
				((LinearLayout) layout.findViewById(R.id.content)).removeAllViews();
				((LinearLayout) layout.findViewById(R.id.content)).addView(contentView,
						new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			}
			dialog.setContentView(layout);
			return dialog;
		}

	}
}
