import {useEffect, useRef, useState, useContext} from "react";
import {Button} from "@material-ui/core";
import AuthContext from "../../context/AuthProvider";
import axios from "../../api/axios";
const LOGIN_URL = '/api/v1/signup'; //ADD IN BACKEND


const LoginPage = () => {
    const {setAuth} = useContext(AuthContext);
    const userRef = useRef();
    const errorRef = useRef();

    const [user, setUser] = useState('');
    const [pwd, setPwd] = useState('');
    const [errorMsg, setErrorMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        userRef.current.focus();
    }, [])

    useEffect(() => {
        setErrorMsg('');
    }, [user, pwd])

    const handleSubmit = async(e) =>{
        e.preventDefault();

        try {
            const response = await axios.post(LOGIN_URL,
                JSON.stringify({ user, pwd }),
                {
                    headers: { 'Content-Type': 'application/json' },
                    withCredentials: true
                }
            );
            setUser('');
            setPwd('');
            setSuccess(true);

        } catch(err){
            if (!err?.response) {
                setErrorMsg('No Server Response');
            } else if (err.response?.status === 400) {
                setErrorMsg('Missing Username or Password');
            } else if (err.response?.status === 401) {
                setErrorMsg('Unauthorized');
            } else {
                setErrorMsg('Login Failed');
            }
            errorRef.current.focus();
        }

    }


    return(
        <>
        {success ? (
            <section>
                <h1>You are logged in!</h1>
                <br />
                <p>
                    <a href={"#"}> Go to main page...</a>
                </p>
                <Button>Huh?</Button>
            </section>
        ) : (

        <section>
            <p ref={errorRef} className={errorMsg ? "errmsg" : "offscreen"} aria-live="assertive">{errorMsg}</p>
            <h1>Sign In</h1>
            <form onSubmit={handleSubmit}>
               <label htmlFor={"email"}>Email:</label>
                <input type={"text"} id={"email"} ref={userRef} autoComplete={"off"}
                       onChange={(e) => setUser(e.target.value)}
                        value={user} required={true}/>
                <br/>
                <label htmlFor={"password"}>Password:</label>
                <input type={"password"} id={"password"} autoComplete={"off"}
                       onChange={(e) => setPwd(e.target.value)}
                       value={pwd} required={true}/>
                <br/>
                <Button type={"submit"}>Login</Button>

                <p>
                    Not registered yet?<br />
                    <span className={"line"}>
                        <a href={"#"}>Sign Up</a>
                    </span>
                </p>

            </form>
        </section>
            )
        }
        </>
    )
}

export default LoginPage;