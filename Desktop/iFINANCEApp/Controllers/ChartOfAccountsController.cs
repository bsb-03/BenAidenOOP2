using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using iFINANCEApp.Models;

namespace iFINANCEApp.Controllers
{
    public class ChartOfAccountsController : Controller
    {

        private Group11_iFINANCEDBEntities db = new Group11_iFINANCEDBEntities();
        // GET: ChartOfAccounts
        public ActionResult ChartOfAccount()
        {
            // check if user is logged in, if not return them to login page
            if (Session["UserName"] == null)
                return RedirectToAction("Login", "Login");


            string userName = Session["UserName"].ToString();
            var user = db.UserPassword.FirstOrDefault(u => u.userName == userName);

            var accounts = db.MasterAccount.Where(m => m.UserID == user.ID).ToList();

            return View(accounts); // return accounts where account id is equal to the user's ID
        }

        [HttpGet]
        public ActionResult AddButtonClick(string id)
        {
            var user = db.UserPassword.Find(id);
            if (user == null)
                return HttpNotFound();

            return View(user);
        }

        [HttpPost]
        public ActionResult AddButtonClick(string nameInput, string openingInput, string closingInput)
        { 
            string userName = Session["UserName"].ToString();
            var user = db.UserPassword.FirstOrDefault(u => u.userName == userName);

            var accounts = db.MasterAccount.Where(m => m.UserID == user.ID).ToList();

            var newEntry = new MasterAccount(); //account
            newEntry.ID = (accounts.Count() + 1).ToString();
            newEntry.UserID = user.ID;
            newEntry.name = nameInput;
            newEntry.openingAmount = Double.Parse(openingInput);
            newEntry.closingAmount = Double.Parse(closingInput);

            db.MasterAccount.Add(newEntry);
            db.SaveChanges(); // this doesnt seem to successfully update the database

            return RedirectToAction("ChartOfAccount");
        }

        [HttpGet]
        public ActionResult EditButtonClick(string id)
        {
            var  masAcc = db.MasterAccount.Find(id);
            if (masAcc == null)
                return HttpNotFound();

            return View(masAcc);
        }

        [HttpPost]
        public ActionResult EditButtonClick(string id, string nameInput, string openingInput, string closingInput)
        {
            var masAcc = db.MasterAccount.Find(id);

            //Console.WriteLine(masAcc.name + " " + masAcc.openingAmount + " " + masAcc.closingAmount);

            if (masAcc != null)
            {
                masAcc.name = nameInput;
                masAcc.openingAmount = Double.Parse(openingInput);
                masAcc.closingAmount = Double.Parse(closingInput);

                db.SaveChanges();
            }
            else
            {
                TempData["ErrorMessage"] = "Account not found.";
            }

            return RedirectToAction("ChartOfAccount");
        }

        [HttpGet]
        public ActionResult DeleteButtonClick(string id)
        {
            var account = db.MasterAccount.Find(id);
            if (account == null)
                return HttpNotFound();

            return View(account);
        }

        [HttpPost]
        public ActionResult DeleteButtonClick(string id, string name)
        {
            var accountToRemove = db.MasterAccount.Find(id);
            if (accountToRemove != null)
            {
                db.MasterAccount.Remove(accountToRemove);
                db.SaveChanges();
            }
            else
            {
                TempData["ErrorMessage"] = "Account not found.";
            }

            return RedirectToAction("ChartOfAccount");
        }

    }
}

